from app.engine.cloud_engine import CloudRemovalEngine
from app.models.cloud_models import CloudRemovalResponse


class CloudRemovalService:

    def __init__(self):
        self.engine = CloudRemovalEngine()

    def remove_clouds(self, image_path):

        output = self.engine.predict(image_path)

        return CloudRemovalResponse(
            success=True,
            message="Cloud removal completed.",
            outputImage=output
        )