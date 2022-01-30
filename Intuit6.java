//Q6.Find in Mountain Array
//Solution by Sakshi Gupta
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int[] peak = getPeak(mountainArr);
        if (peak[1] == target) {
            return peak[0];
        }
        int left = getValLeft(mountainArr, peak[0], target);

        if (left != -1) {
            return left;
        }

        return getValRight(mountainArr, peak[0], target);
    }

    private int[] getPeak(MountainArray mountainArray) {
        int len = mountainArray.length();

        int left = 0;
        int right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int val = mountainArray.get(mid);
            boolean skipLeft = false;
            int valLeft = -1;
            if (mid - 1 < 0) {
                skipLeft = true;
            } else {
                valLeft = mountainArray.get(mid - 1);
            }

            int valRight = -1;
            boolean skipRight = false;
            if (mid + 1 > len - 1) {
                skipRight = true;
            } else {
                valRight = mountainArray.get(mid + 1);
            }

            if ((skipLeft || valLeft < val) && (skipRight || val > valRight)) {
                return new int[] {mid, val};
            } else if ((skipLeft || valLeft < val) && ( skipRight || val < valRight))  {//left side
                left = mid + 1;
            } else if ((skipLeft || valLeft > val) && ( skipRight || val > valRight)) {
                right = mid - 1;
            }
        }
        return null;
    }

    private int getValLeft(MountainArray mountainArray, int peakId, int target) {
        int left = 0;
        int right = peakId - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int val = mountainArray.get(mid);
            if (val == target) {
                return mid;
            } else if (val < target)  {//left side
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int getValRight(MountainArray mountainArray, int peakId, int target) {
        int len = mountainArray.length();

        int left = peakId + 1;
        int right = len - 1;
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            int val = mountainArray.get(mid);
            if (val == target) {
                return mid;
            } else if (val > target)  {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
