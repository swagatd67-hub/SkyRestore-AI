import cv2


class CloudReconstructor:

    def reconstruct(self, image, mask):

        result = cv2.inpaint(
            image,
            mask,
            5,
            cv2.INPAINT_TELEA
        )

        return result