class SnakeGame {
    LinkedList<int[]> snake;
    LinkedList<int[]> foodList;
    int width; int height;
    int[] snakeHead;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        foodList = new LinkedList<>(Arrays.asList(food));
        snakeHead = new int[]{0, 0};
        snake = new LinkedList<>();
        snake.add(snakeHead);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String directions) {
        if(directions.equals("U")) snakeHead[0]--;
        if(directions.equals("D")) snakeHead[0]++;
        if(directions.equals("L")) snakeHead[1]--;
        if(directions.equals("R")) snakeHead[1]++;
        
        //boundary check
        if(snakeHead[0] >= height || snakeHead[0] < 0 || snakeHead[1] >= width || snakeHead[1] < 0){
            return -1;
        }
        //it hits itself
        for(int i = 1; i < snake.size(); i++){
            int[] curr = snake.get(i);
            if(curr[0] == snakeHead[0] && curr[1] == snakeHead[1]){
                return -1;
            }
        }
        
        //food
        if(!foodList.isEmpty()){
            int[] food = foodList.get(0);
            if(food[0] == snakeHead[0] && food[1] == snakeHead[1]){
                snake.add(foodList.remove());
                return snake.size() - 1;
            }
        }
        snake.remove();
        snake.add(new int[]{snakeHead[0], snakeHead[1]});
        return snake.size() - 1;
    }
}
​
/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
