from dotenv import load_dotenv
from langchain_openai import OpenAIEmbeddings
from langchain_community.vectorstores import FAISS
from langchain_core.prompts import ChatPromptTemplate
from langchain_community.chat_models import ChatOllama
from langchain_core.runnables import RunnablePassthrough


# 랭스미스 연결
load_dotenv(dotenv_path="../env/.env")

# 임베딩 모델 로드
embedding_model = OpenAIEmbeddings()


# Local FAISS 로드
vectorstore = FAISS.load_local(
    "./db/faiss",
    embedding_model,
    allow_dangerous_deserialization=True
)

# retriever 생성
retriever = vectorstore.as_retriever(
    search_type="similarity",
    search_kwars={"k":15}
)

message = """
Answer this question using the provided context only.

{question}

Context:
{context}

"""

# 프롬프트 템플릿 생성
prompt = ChatPromptTemplate.from_messages(
    [
        ("system", "당신은 반도체와 관련된 경제 상황을 분석할 수 있는 전문가입니다. 고등학생들 수준으로도 이해할 수 있게 잘 답변해 주세요. 답변은 한국어로 해주세요."),
        ("human", message)
    ]
)

# LLM 모델 로드
model = ChatOllama(
    model = "gemma2:2b",
    temperature=0.4
)

# RAG chain 생성
chain = {"context": retriever, "question":RunnablePassthrough()} | prompt | model

from fastapi import FastAPI, Form
from typing import Annotated


app = FastAPI()

# tags는 swagger 설정
@app.post("/semiconductor", tags=["반도체"])
async def semiconductor(question:Annotated[str, Form()]):
    return {"answer": chain.invoke(question).content}