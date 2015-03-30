/*
 * Copyright (C) 2015 Jan Mucha <j.mucha@seznam.cz>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package rfm01.command;

/**
 *
 * @author Jan Mucha <j.mucha@seznam.cz>
 * @version %I%, %G%
 * @since
 */
public class WakeupTimer implements Command {

    private static final int CMD = 0xE000;

    private int value = 0xE196;

    private static final int MAX_R = 0x1F;
    private static final int MAX_M = 0xFF;

    private static final int R_MASK = 0x1F00;
    private static final int R_BITOFFSET = 8;

    private static final int M_MASK = 0xFF;
    private static final int M_BITOFFSET = 0;

    @Override
    public int getValue() {
        return value;
    }

    public int getM() {
        return value & M_MASK;
    }

    /**
     *
     * @param timeout: Timeout in ms.
     */
    public void setTimer(int timeout) {
        int minR = timeout / 0xFF;
        int maxR;
        int tmp = timeout;
        for (maxR = 0; maxR <= MAX_R; maxR++) {
            tmp /= 2;
            if (tmp < 1) {
                break;
            }
        }
        int minDelta = Integer.MAX_VALUE;
        int TmpR = 0;
        int TmpM = 0;
        int c1 = 1;
        for (int i = 1; i <= minR; i++) {
            c1 *= 2;
        }
        for (int r = minR; r <= maxR; r++) {
            for (int m = 0; m < MAX_M; m++) {
                int Twup = m * c1;
                int delta = Math.abs(timeout - Twup);
                if (delta < minDelta) {
                    minDelta = delta;
                    TmpM = m;
                    TmpR = r;
                    if (minDelta == 0) {
                        break;
                    }
                }
            }
            if (minDelta == 0) {
                break;
            }
            c1 *= 2;
        }

        value &= ~R_MASK;
        value |= (TmpR << R_BITOFFSET);

        value &= ~M_MASK;
        value |= TmpM;
    }

}
