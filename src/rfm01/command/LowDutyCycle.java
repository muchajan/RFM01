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
public class LowDutyCycle implements Command {

    private static final int CMD = 0xCC00;
    private static final int D_MASK = 0xFE;
    private static final int D_BITOFFSET = 1;

    private static final int EN_MASK = 1;

    private int value = 0xCC0E;

    @Override
    public int getValue() {
        return value;
    }

    /**
     *
     * @param dc: Duty cycle percentage
     * @param m: M parameter from Wake-up timer command
     */
    public void setLowDutyCycle(float dc, int M) {
        int D = (int) (dc / 100 * M - 1) / 2;
        value &= ~D_MASK;
        value |= D << D_BITOFFSET;
    }

    /**
     *
     * @param en: Whether enable Low Duty Cycle
     */
    public void setEnable(boolean en) {
        value &= ~EN_MASK;
        if (en) {
            value |= 1;
        }
    }
}
