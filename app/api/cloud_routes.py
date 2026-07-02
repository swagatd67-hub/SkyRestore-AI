import os
import shutil

from fastapi import APIRouter, UploadFile, File
from fastapi.responses import FileResponse

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

    os.makedirs("app/uploads", exist_ok=True)

    file_path = os.path.join(
        "app/uploads",
        file.filename
    )

    with open(file_path, "wb") as buffer:
        shutil.copyfileobj(file.file, buffer)

    output = service.remove_clouds(file_path)

    return FileResponse(
        output,
        media_type="image/jpeg",
        filename="clean_image.jpg"
    )