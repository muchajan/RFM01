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

import rfm01.command.lowbatclockdiv.ClockOutputFreq;

/**
 *
 * @author Jan Mucha <j.mucha@seznam.cz>
 * @version %I%, %G%
 * @since
 */
public class LowBatClocDiv implements Command {

    private static final int CMD = 0xC200;

    private static final int COF_MASK = 0xE0;
    private static final int COF_BITOFFSET = 5;

    private static final int T_MASK = 0x1F;

    private int value = 0xC200;

    public void setClockOutputFreq(ClockOutputFreq cof) {
        value &= ~COF_MASK;
        value |= cof.ordinal() << COF_BITOFFSET;
    }

    /**
     *
     * @param Vlb
     */
    public void setLowBatTreshold(float Vlb) {
        int T = (int) ((Vlb - 2.25) / 0.1);
        value &= ~T_MASK;
        value |= T;
    }

    @Override
    public int getValue() {
        return value;
    }
}
