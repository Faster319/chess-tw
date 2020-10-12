package uk.ac.warwick.dcs.chess.piece;
import uk.ac.warwick.dcs.chess.*;
public class Knight extends ChessPiece {
    private static final long serialVersionUID = 1L;
    public Knight(Board board, boolean isWhite, int vertical, int horizontal) {
        super(board, isWhite, (char)((int)ChessIcons.W_KNIGHT + (isWhite ? 0 : 6)), vertical, horizontal);
    }

    @Override
    public Move[] getAvailableMoves() {
        availableMoves.clear();

        int moveH, moveV;

        // Up Right
        moveV = this.vertical - 2;
        moveH = this.horizontal + 1;
        addMove(moveV, moveH);

        // Right Up
        moveV = this.vertical - 1;
        moveH = this.horizontal + 2;
        addMove(moveV, moveH);

        // Right Down
        moveV = this.vertical + 1;
        moveH = this.horizontal + 2;
        addMove(moveV, moveH);

        // Down Right
        moveV = this.vertical + 2;
        moveH = this.horizontal + 1;
        addMove(moveV, moveH);

        // Down Left
        moveV = this.vertical + 2;
        moveH = this.horizontal - 1;
        addMove(moveV, moveH);

        // Left Down
        moveV = this.vertical + 1;
        moveH = this.horizontal - 2;
        addMove(moveV, moveH);

        // Left Up
        moveV = this.vertical - 1;
        moveH = this.horizontal - 2;
        addMove(moveV, moveH);

        // Up Left
        moveV = this.vertical - 2;
        moveH = this.horizontal - 1;
        addMove(moveV, moveH);


        return availableMoves.movesToArray();
    }

    private void addMove(int moveV, int moveH) {
      // To empty space.
      if (board.locationValid(moveV, moveH) && board.pieceAtLocation(moveV, moveH) == null) {
        Move m = new Move(this, moveV,moveH, false);
        availableMoves.add(m);
      }

      // To take piece.
      if (board.locationValid(moveV, moveH) && board.pieceAtLocation(moveV, moveH) != null && board.pieceAtLocation(moveV, moveH).isWhite != this.isWhite) {
        Move m = new Move(this, moveV,moveH, true);
        availableMoves.add(m);
      }
    }

}
