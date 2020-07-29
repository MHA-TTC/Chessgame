package com.chess.engine.board;

import com.chess.engine.Pieces.Piece;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    //REPRESENTS TILE NUMBER
    protected final int tileCoordinate;

    private static final Map<Integer,EmptyTile> EMPTY_TILES  = createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for (int i = 0; i < 64; i++){
            emptyTileMap.put(i,new EmptyTile(i));
        }
        return emptyTileMap;
    }

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

        EmptyTile(final int coordinate) {
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
        private final Piece pieceOnTile;

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
