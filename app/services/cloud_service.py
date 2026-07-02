from app.engine.cloud_engine import CloudRemovalEngine


class CloudRemovalService:

    def __init__(self):

        self.engine = CloudRemovalEngine()

    def remove_clouds(self, image_path):

        return self.engine.predict(image_path)