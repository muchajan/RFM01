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

import rfm01.command.datafilter.FilterType;

/**
 *
 * @author Jan Mucha <j.mucha@seznam.cz>
 * @version %I%, %G%
 * @since
 */
public class DataFilter implements Command {

    private static final int CMD = 0xC400;

    private static final int AL_MASK = 0x80;
    private static final int AL_BITOFFSET = 7;

    private static final int ML_MASK = 0x40;
    private static final int ML_BITOFFSET = 6;

    private static final int S_MASK = 0x18;
    private static final int S_BITOFFSET = 3;

    private static final int DQD_MASK = 0x7;
    private int value = 0xC42C;

//    private static final int
    @Override
    public int getValue() {
        return value;
    }

    /**
     * Clock recovery (CR) auto lock control if set. It means that the CR start
     * in fast mode after locking it automatically switches to slow mode.
     *
     * @param al
     */
    public void setClockRecoveryAutoLock(boolean al) {
        value &= ~AL_MASK;
        if (al) {
            value |= AL_MASK;
        }
    }

    public void setClockRecoveryLock(boolean ml) {
        value &= ~ML_MASK;
        if (ml) {
            value |= ML_MASK;
        }
    }

    public void setFilterType(FilterType df) {
        value &= ~S_MASK;
        value |= df.ordinal() << S_BITOFFSET;
    }

    /**
     * DQD threshold parameter. To let the DQD report "good signal quality" the
     * threshold parameter should be less than 4 in the case when the bitrate is
     * close to the deviation. At higher deviation/bitrate settings higher
     * threshold parameter can report "good signal quality" as well.
     *
     * @param dqd
     */
    public void setDQD(int dqd) {
        if (dqd > 7 || dqd < 0) {
            return;
        }
        value &= ~DQD_MASK;
        value |= dqd;
    }

}
