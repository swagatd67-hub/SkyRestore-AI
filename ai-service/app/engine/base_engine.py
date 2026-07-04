from abc import ABC, abstractmethod


class BaseCloudEngine(ABC):

    @abstractmethod
    def load_model(self):
        pass

    @abstractmethod
    def predict(self, image_path):
        pass