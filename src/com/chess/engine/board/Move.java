package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public abstract class Move {
     final Board board;
     final Piece movedPiece;

    public int getDestinationCoordinate() {
        return destinationCoordinate;
    }
//adde grt destination

    final int destinationCoordinate;


    public Piece getMovedPiece() {
        return movedPiece;
    }

//    added git moves

    public Move(final Board board, final Piece movedPiece, final int destinationCoordinate) {
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }

    public static final class MajorMove extends Move {

        public MajorMove(final Board board,final  Piece movedPiece,
                         final  int destinationCoordinate) {
            super(board, movedPiece, destinationCoordinate);
        }
    }
    public static final class attackMove extends Move{
        final Piece attackedPiece;

        public attackMove(final Board board,final  Piece movedPiece,
                          final int destinationCoordinate, final Piece attackedPiece) {
            super(board, movedPiece, destinationCoordinate);
            this.attackedPiece = attackedPiece;


        }
    }
}
