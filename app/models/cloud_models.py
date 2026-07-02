from pydantic import BaseModel


class CloudRemovalResponse(BaseModel):

    success: bool

    message: str

    outputImage: str | None = None