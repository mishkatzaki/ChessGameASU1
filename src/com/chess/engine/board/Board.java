package com.chess.engine.board;

import com.chess.engine.pieces.*;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Map;

public class Board {

    private final List<Tile> gameBoard;

    private Board(Builder builder){
        this.gameBoard = createGameBoard(builder);
    }

    public Tile getTile(final int tileCoordinate){
        return null;  //TODO returns null
    }
    private static List<Tile>createGameBoard(final Builder builder){
        final Tile[] tiles= new Tile[BoardUtils.NUM_TILES];
        for (int i=0; i<BoardUtils.NUM_TILES ; i++){
            tiles[i]= Tile.createTile(i, builder.boardConfig.get(i));
        }
        return ImmutableList.copyOf(tiles);
    }
    public static Board createStandardBoard() {
        final Builder builder = new Builder();
    // black standard
        //Strong
    builder.setPiece(new Rook(0, Alliance.BLACK));
    builder.setPiece(new Knight(1, Alliance.BLACK));
    builder.setPiece (new Bishop(2, Alliance.BLACK));
    builder.setPiece(new Queen(3, Alliance.BLACK));
    builder.setPiece(new King(4, Alliance.BLACK));
    builder.setPiece (new Bishop(5, Alliance.BLACK));
    builder.setPiece(new Knight(6, Alliance.BLACK));
    builder.setPiece(new Rook(7, Alliance.BLACK));
        // Pawns
    builder.setPiece(new Pawn(8, Alliance.BLACK));
    builder.setPiece(new Pawn(9, Alliance.BLACK));
    builder.setPiece(new Pawn(10, Alliance.BLACK));
    builder.setPiece(new Pawn(11, Alliance.BLACK));
    builder.setPiece(new Pawn(12, Alliance.BLACK));
    builder.setPiece(new Pawn(13, Alliance.BLACK));
    builder.setPiece(new Pawn(14, Alliance.BLACK));
    builder.setPiece(new Pawn(15, Alliance.BLACK));


        return Builder.build();
    }

    public static class Builder{
        Map<Integer, Piece>   boardConfig;
        Alliance nextMoveMaker;

        public  Builder(){

        }

        public Builder setPiece(final Piece piece){
            this.boardConfig.put(piece.getPiecePosition(), piece);
            return this;
        }
        public Builder setMoveMaker(final Piece piece){
            this.boardConfig.put(piece.getPiecePosition(), piece);
            return this;
        }


        public Board build(){
            return new Board(this);
        }
    }
}
