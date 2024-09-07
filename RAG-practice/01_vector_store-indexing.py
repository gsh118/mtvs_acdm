from dotenv import load_dotenv
from langchain_community.document_loaders import PyPDFLoader
from langchain_openai import OpenAIEmbeddings
from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain_community.vectorstores import FAISS
from langchain_community.vectorstores.utils import DistanceStrategy

load_dotenv(dotenv_path="../99_env/.env")

loader = PyPDFLoader("./semiconductor_info.pdf")

documents = loader.load()
embedding_model = OpenAIEmbeddings()

text_splitter = RecursiveCharacterTextSplitter(chunk_size=300, chunk_overlap=30)
texts = text_splitter.split_documents(documents)

for text in texts:
    print(text)


vectorstore = FAISS.from_documents(
    texts,
    embedding=embedding_model,
    distance_strategy= DistanceStrategy.COSINE
)

vectorstore.save_local("./db/faiss")