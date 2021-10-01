package Pieces;

import java.util.ArrayList;

public class Piece {

    private boolean _isAlive;
    private boolean _color; //true=white false=black
    private int[] _position;

    public Piece(boolean color) {
        _color = color;
        _isAlive = true;
    }

    public int[] getPosition() {
        return _position;
    }

    public boolean getIsAlive() {
        return _isAlive;
    }

    public boolean getColor(){
        return _color;
    }

    public int[][] findMoves() {
        ArrayList<int[]> moveList = new ArrayList<>();
        int[][] possibleMoves = new int[][] {
                {getPosition()[0], getPosition()[1]+1},//
                {getPosition()[0], getPosition()[1]-1},
                {getPosition()[0]+1, getPosition()[1]},
                {getPosition()[0]-1, getPosition()[1]},
                {getPosition()[0]+1, getPosition()[1]+1},//
                {getPosition()[0]+1, getPosition()[1]-1},
                {getPosition()[0]-1, getPosition()[1]+1},//
                {getPosition()[0]-1, getPosition()[1]-1}};
        moveList = validate(moveList, possibleMoves);
        int[][] moves = new int[moveList.size()][1];
        for(int i = 0; i< moveList.size(); i++) {
            moves[i] = moveList.get(i);
        }
        return moves;
    }

    public void setPosition(int[] newPosition) {
        _position = newPosition;
    }

    public void kill() {
        _isAlive = false;
    }

    protected ArrayList<int[]> validate(ArrayList<int[]> moveList, int[][] possibleMoves) {
        for(int[] row : possibleMoves) {
            if(row[0] >= 1 && row[0] <=8 && row[1] >= 1 && row[1] <= 8) {
                moveList.add(row);
            }
        }
        return moveList;
    }
}
