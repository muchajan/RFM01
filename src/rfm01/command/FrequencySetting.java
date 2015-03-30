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

import rfm01.command.configurationsetting.Band;

/**
 *
 * @author Jan Mucha j.mucha@seznam.cz
 */
public class FrequencySetting implements Command {

    private static final int CMD = 0xA000;

    private static final int F_MASK = 0x0FFF;

    private int value = 0xA680;

    public boolean setFrequency(Band band, int freq) {
        if (freq < 96 || freq > 3903) {
            return false;
        }

        int c1 = 0, c2 = 0;

        switch (band) {
            case _315MHz:
                c1 = 1;
                c2 = 31;
                break;
            case _433MHz:
                c1 = 1;
                c2 = 43;
                break;
            case _868MHz:
                c1 = 2;
                c2 = 43;
                break;
            case _915MHz:
                c1 = 3;
                c2 = 30;
                break;
            default:
                break;
        }

        int f = 10 * c1 * (c2 + freq / 4000);

        value &= ~F_MASK;
        value |= f;

        return true;
    }

    @Override
    public int getValue() {
        return value & 0xFFFF;
    }
}
