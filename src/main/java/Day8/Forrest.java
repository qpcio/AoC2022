package Day8;

public class Forrest {
    private int forrestSize;
    private int[][] heights;

    public int countVisible() {
        int count = 0;
        for (int y = 0; y < forrestSize; y++) {
            for (int x = 0; x < forrestSize; x++) {
                if (isVisible(x, y)) count++;
            }
        }
        return count;
    }

    private boolean isVisible(int x, int y) {
        if (x == 0 || y == 0 || x == forrestSize - 1 || y == forrestSize - 1) return true;
        return isVisibleEast(x, y) ||
                isVisibleWest(x, y) ||
                isVisibleNorth(x, y) ||
                isVisibleSouth(x, y);

    }

    private boolean isVisibleWest(int x, int y) {
        int height = heights[x][y];
        for (int i = 1; x - i >= 0; i++) {
            if (heights[x - i][y] >= height) return false;
        }
        return true;
    }

    private boolean isVisibleEast(int x, int y) {
        int height = heights[x][y];
        for (int i = 1; x + i < forrestSize; i++) {
            if (heights[x + i][y] >= height) return false;
        }
        return true;
    }

    private boolean isVisibleNorth(int x, int y) {
        int height = heights[x][y];
        for (int i = 1; y - i >= 0; i++) {
            if (heights[x][y - i] >= height) return false;
        }
        return true;
    }

    private boolean isVisibleSouth(int x, int y) {
        int height = heights[x][y];
        for (int i = 1; y + i < forrestSize; i++) {
            if (heights[x][y + i] >= height) return false;
        }
        return true;
    }

    public Forrest(int[][] heights) {
        this.heights = heights;
        forrestSize = heights.length;
    }

    private int visibleNorth(int x, int y) {
        int result = 1;
        int height = heights[x][y];
        for (int i = 1; y - i >= 0; i++) {
            if (heights[x][y - i] >= height) {
                return result;
            }
            result++;
        }
        return result - 1;
    }

    private int visibleSouth(int x, int y) {
        int result = 1;
        int height = heights[x][y];
        for (int i = 1; y + i < forrestSize; i++) {
            if (heights[x][y + i] >= height) {
                return result;
            }
            result++;
        }
        return result - 1;
    }

    private int visibleEast(int x, int y) {
        int result = 1;
        int height = heights[x][y];
        for (int i = 1; x + i < forrestSize; i++) {
            if (heights[x + i][y] >= height) {
                return result;
            }
            result++;
        }
        return result - 1;
    }

    private int visibleWest(int x, int y) {
        int result = 1;
        int height = heights[x][y];
        for (int i = 1; x - i >= 0; i++) {
            if (heights[x - i][y] >= height) {
                return result;
            }
            result++;
        }
        return result - 1;
    }

    public int scenicScore(int x, int y) {
        if (x == 0 || y == 0 || x == forrestSize - 1 || y == forrestSize - 1) return 0;
        return visibleNorth(x, y) * visibleSouth(x, y) * visibleEast(x, y) * visibleWest(x, y);
    }

    public int getLargestScenicScore() {
        int maxScenicScore = 0;
        for (int y = 0; y < forrestSize; y++) {
            for (int x = 0; x < forrestSize; x++) {
                int currentScenicScore = scenicScore(x, y);
                if (currentScenicScore > maxScenicScore) maxScenicScore = currentScenicScore;
            }
        }
        return maxScenicScore;
    }

}
