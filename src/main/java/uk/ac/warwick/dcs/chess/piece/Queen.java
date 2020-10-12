package uk.ac.warwick.dcs.chess.piece;
import uk.ac.warwick.dcs.chess.*;
public class Queen extends ChessPiece {
    private static final long serialVersionUID = 1L;
    public Queen(Board board, boolean isWhite, int vertical, int horizontal) {
        super(board, isWhite, (char)((int)ChessIcons.W_QUEEN + (isWhite ? 0 : 6)), vertical, horizontal);
    }

    @Override
    public Move[] getAvailableMoves() {
        availableMoves.clear();
        int moveV, moveH;
        boolean maxUp = false, maxDown = false, maxRight = false, maxLeft = false;

        for (int i  = 1; i < 8; i++) {

          // Up
          if (!maxUp) {
            moveV = this.vertical - i;
            moveH = this.horizontal;
            maxUp = addMove(moveV, moveH);
          }

          // Down
          if (!maxDown) {
            moveV = this.vertical + i;
            moveH = this.horizontal;
            maxDown = addMove(moveV, moveH);
          }

          // Right
          if (!maxRight) {
            moveV = this.vertical;
            moveH = this.horizontal + i;
            maxRight = addMove(moveV, moveH);
          }

          // Left
          if (!maxLeft) {
            moveV = this.vertical;
            moveH = this.horizontal - i;
            maxLeft = addMove(moveV, moveH);
          }

          // Top Right
          if (!maxUp) {
            moveV = this.vertical - i;
            moveH = this.horizontal + i;
            maxUp = addMove(moveV, moveH);
          }

          // Bottom Right
          if (!maxDown) {
            moveV = this.vertical + i;
            moveH = this.horizontal + i;
            maxDown = addMove(moveV, moveH);
          }

          // Top Left
          if (!maxRight) {
            moveV = this.vertical - i;
            moveH = this.horizontal - i;
            maxRight = addMove(moveV, moveH);
          }

          // Bottom Left
          if (!maxLeft) {
            moveV = this.vertical + i;
            moveH = this.horizontal - i;
            maxLeft = addMove(moveV, moveH);
          }
        }

        return availableMoves.movesToArray();
    }

    private boolean addMove(int moveV, int moveH) {
      // To empty space.
      if (board.locationValid(moveV, moveH) && board.pieceAtLocation(moveV, moveH) == null) {
        Move m = new Move(this, moveV,moveH, false);
        availableMoves.add(m);
        return false;
      }

      // To take piece.
      if (board.locationValid(moveV, moveH) && board.pieceAtLocation(moveV, moveH) != null && board.pieceAtLocation(moveV, moveH).isWhite != this.isWhite) {
        Move m = new Move(this, moveV,moveH, true);
        availableMoves.add(m);
        return true;
      }
      return true;
    }
}
