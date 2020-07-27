package com.chess.engine.board;

import com.chess.engine.Pieces.Piece;

public abstract class Tile {

    //REPRESENTS TILE NUMBER
    int tileCoordinate;

    //CREATES INDIVIDUAL TILE
    Tile(int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }

    //TELLS US IF A GIVEN TILE IS OCCUPIED OR NOT
    public abstract boolean isTileOccupied();

    //GETS PIECES OFF OF A GIVEN TILE
    public abstract Piece getPiece();


    /*EMPTY TILE SUB CLASS*/
    public static final class EmptyTile extends Tile{

        EmptyTile(int coordinate) {
            super(coordinate);
        }
        @Override
        public boolean isTileOccupied() {
            return false;
        }
        @Override
        public Piece getPiece(){
            return null;
        }
    }

    /*OCCUPIED TILE SUB CLASS*/
    public static final class OccupiedTile extends Tile{
        Piece pieceOnTile;

        OccupiedTile(int tileCoordinate , Piece pieceOnTile){
            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;
        }

        @Override
        public boolean isTileOccupied(){
            return true;
        }
        @Override
        public Piece getPiece(){
            return this.pieceOnTile;
        }

    }
}
