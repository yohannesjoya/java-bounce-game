import java.awt.*;

public class Map {
    public int[][] map;
    public int width;
    public int height;

    public Map(int row, int col) {
        map = new int[row][col];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = 1;

            }
        }
        width = 540 / col;
        height = 150 / row;

    }
    public void draw(Graphics2D g2d) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    g2d.setColor(Color.white);
                    g2d.fillRect(j * width + 20, i * height + 30, width, height);

                    g2d.setStroke(new BasicStroke(3));
                    g2d.setColor(Color.GRAY);
                    g2d.drawRect(j*width+20,i*height+30,width,height);
                }
            }
        }

    }
}
