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

import rfm01.command.automaticfrequencycontrol.AutomaticOperationMode;
import rfm01.command.automaticfrequencycontrol.RangeLimit;

/**
 *
 * @author Jan Mucha <j.mucha@seznam.cz>
 * @version %I%, %G%
 * @since
 */
public class AutomaticFrequencyControl implements Command {

    private static final int CMD = 0xC600;

    private static final int EN_MASK = 0x1;
    private static final int OE_MASK = 0x2;
    private static final int FI_MASK = 0x3;
    private static final int ST_MASK = 0x4;

    private static final int RL_MASK = 0x30;
    private static final int RL_BITOFFSET = 4;

    private static final int A_MASK = 0xC0;
    private static final int A_BITOFFSET = 6;

    private int value = 0xC6F7;

    @Override
    public int getValue() {
        return value;
    }

    /**
     * Enables the calculation of the offset frequency by the AFC circuit (it
     * allows the addition of the content of the output register to the
     * frequency control word of the PLL).
     *
     * @param en:
     */
    public void setEnable(boolean en) {
        value &= ~EN_MASK;
        if (en) {
            value |= EN_MASK;
        }
    }

    /**
     * When set, enables the output (frequency offset) register
     *
     * @param oe
     */
    public void setOutput(boolean oe) {
        value &= ~OE_MASK;
        if (oe) {
            value |= OE_MASK;
        }
    }

    /**
     * When set, switches the circuit to high accuracy (fine) mode. In this case
     * the processing time is about four times longer, but the measurement
     * ucertainty is less than half.
     *
     * @param fi
     */
    public void setFine(boolean fi) {
        value &= ~FI_MASK;
        if (fi) {
            value |= FI_MASK;
        }
    }

    /**
     * Strobe edge, when st goes to high, the actual latest calculated frequency
     * error is stored into the output registers of the AFC block.
     *
     * @param st
     */
    public void setStrobe(boolean st) {
        value &= ~ST_MASK;
        if (st) {
            value |= ST_MASK;
        }
    }

    public void setRangeLimit(RangeLimit rl) {
        value &= ~RL_MASK;
        value |= rl.ordinal() << RL_BITOFFSET;
    }

    /**
     * Automatic operation mode set
     *
     * @param a
     */
    public void setAutomaticOperationMode(AutomaticOperationMode a) {
        value &= ~A_MASK;
        value |= a.ordinal() << A_BITOFFSET;
    }

}
