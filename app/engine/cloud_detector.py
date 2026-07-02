import cv2
import numpy as np


class CloudDetector:

    def detect(self, image):

        hsv = cv2.cvtColor(image, cv2.COLOR_BGR2HSV)

        lower = np.array([0, 0, 180])
        upper = np.array([180, 70, 255])

        mask = cv2.inRange(hsv, lower, upper)

        return mask