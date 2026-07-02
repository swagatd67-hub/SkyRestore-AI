import os
import cv2
import torch
import requests
import numpy as np

from app.engine.base_engine import BaseCloudEngine
from app.engine.cloud_detector import CloudDetector
from app.engine.cloud_reconstructor import CloudReconstructor


class CloudRemovalEngine(BaseCloudEngine):

    def __init__(self):

        self.device = (
            "cuda"
            if torch.cuda.is_available()
            else "cpu"
        )

        print("=" * 40)
        print("SkyRestore AI Engine")
        print("Running on:", self.device)
        print("=" * 40)

        self.detector = CloudDetector()
        self.reconstructor = CloudReconstructor()

        self.load_model()

    def load_model(self):

        print("Loading Cloud Removal Engine...")
        print("Cloud Engine Ready.")

    def predict(self, image_path):

        # Create folders if they don't exist
        os.makedirs("app/uploads", exist_ok=True)
        os.makedirs("app/outputs", exist_ok=True)

        # -----------------------------
        # Load Image
        # -----------------------------
        if image_path.startswith("http"):

            print("Downloading image from URL...")

            response = requests.get(image_path)

            if response.status_code != 200:
                raise Exception("Failed to download image.")

            image = cv2.imdecode(
                np.frombuffer(response.content, np.uint8),
                cv2.IMREAD_COLOR
            )

            cv2.imwrite("app/uploads/input.jpg", image)

        else:

            print("Reading local image...")

            image = cv2.imread(image_path)

        if image is None:
            raise Exception("Unable to load image.")

        print("Image Loaded Successfully")

        # -----------------------------
        # Cloud Detection
        # -----------------------------
        print("Detecting Clouds...")

        mask = self.detector.detect(image)

        cv2.imwrite("app/outputs/cloud_mask.png", mask)

        # -----------------------------
        # Cloud Reconstruction
        # -----------------------------
        print("Removing Clouds...")

        result = self.reconstructor.reconstruct(image, mask)

        output_path = "app/outputs/output_clean.jpg"

        cv2.imwrite(output_path, result)

        print("Cloud Removal Completed")

        return output_path