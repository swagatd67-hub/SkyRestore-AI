import os
import shutil

from fastapi import APIRouter, UploadFile, File

from app.services.cloud_service import CloudRemovalService

router = APIRouter(
    prefix="/cloud",
    tags=["Cloud Removal"]
)

service = CloudRemovalService()


@router.get("/health")
def health():
    return {
        "status": "Cloud AI Ready"
    }


@router.post("/remove")
async def remove_clouds(file: UploadFile = File(...)):

    # Create uploads folder
    os.makedirs("app/uploads", exist_ok=True)

    # Save uploaded image
    file_path = os.path.join("app/uploads", file.filename)

    with open(file_path, "wb") as buffer:
        shutil.copyfileobj(file.file, buffer)

    # Pass FULL PATH to AI engine
    return service.remove_clouds(file_path)