package game;

public class Rectangle {
    Vector2D position; // vị trí hình chữ nhật (góc trên bên trái)
    int width; // chiều rộng hcn
    int height; // chiều cao hcn

    public Rectangle() {
        this(new Vector2D(), 1, 1);
    }

    public Rectangle(Vector2D position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public float top() {
        return this.position.y;
    }

    public float bot() {
        return this.top() + this.height;
    }

    public float left() {
        return this.position.x;
    }

    public float right() {
        return this.left() + this.width;
    }

    /**
     * @param other
     * @return true: nếu hình chữ nhật được gọi (this) có phần
     * giao với hình chữ nhật truyền vào (other)
     * @return false: nếu 2 hình chữ nhật ko giao nhau
     */
    public boolean intersects(Rectangle other) {
        // TODO: 1. Triển khai phần code kiểm tra va chạm giữa 2 hình chữ nhật ở đây

        return this.bot() >= other.top()
                && this.top() <= other.bot()
                && this.left() <= other.right()
                && this.right() >= other.left();

//        if (this.position.y > other.position.y + other.height
//            || this.position.y + this.height < other.position.y) {
//            return false;
//        }
//        if (this.position.x + this.width < other.position.x
//            || this.position.x > other.position.x +other.width) {
//            return false;
//        }
//        return true;
    }

    //TODO: 2. Chạy hàm main này để test
    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(new Vector2D(5, 5), 3, 3);
        Rectangle rect2 = new Rectangle(new Vector2D(4, 4), 3, 3);
        Rectangle rect3 = new Rectangle(new Vector2D(10, 10), 3, 3);
        System.out.println(String.format("rect1 intersects rect2: %s (correct: true)", rect1.intersects(rect2)));
        System.out.println(String.format("rect2 intersects rect1: %s (correct: true)", rect2.intersects(rect1)));
        System.out.println(String.format("rect1 intersects rect3: %s (correct: false)", rect1.intersects(rect3)));
        System.out.println(String.format("rect3 intersects rect2: %s (correct: false)", rect3.intersects(rect2)));
    }
}
