from fastapi import FastAPI

from app.api.cloud_routes import router as cloud_router

app = FastAPI(
    title="SkyRestore AI Service",
    description="Generative AI Cloud Removal",
    version="1.0"
)

app.include_router(cloud_router)

@app.get("/")
def home():
    return {
        "status": "Running",
        "service": "SkyRestore AI",
        "gpu": "Enabled"
    }