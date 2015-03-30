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
import rfm01.command.configurationsetting.BasebandBandwidth;
import rfm01.command.configurationsetting.CrystalLoadCap;

/**
 *
 * @author Jan Mucha j.mucha@seznam.cz
 */
public class ConfigurationSetting implements Command {

    private static final int CMD = 0x8000;

    private static final int BAND_MASK = 0x1800;
    private static final int BAND_BITOFFSET = 11;

    private static final int EB_MASK = 0x0400;
    private static final int EB_BITOFFSET = 10;

    private static final int ET_MASK = 0x0200;
    private static final int ET_BITOFFSET = 9;

    private static final int EX_MASK = 0x0100;
    private static final int EX_BITOFFSET = 8;

    private static final int CLC_MASK = 0x00F0;
    private static final int CLC_BITOFFSET = 4;

    private static final int BB_MASK = 0x000E;
    private static final int BB_BITOFFSET = 1;

    private static final int DC_MASK = 0x0001;
    private static final int DC_BITOFFSET = 0;

    private int value = 0x893A;

    public ConfigurationSetting() {

    }

    public void setFrequencyBand(Band band) {
        value &= ~BAND_MASK;
        value |= (band.ordinal() << BAND_BITOFFSET);
    }

    public void enableBatteryDetector(boolean eb) {
        int val = eb ? 1 : 0;
        value &= ~EB_MASK;
        value |= (val << EB_BITOFFSET);
    }

    public void enableWakeupTimer(boolean et) {
        int val = et ? 1 : 0;
        value &= ~ET_MASK;
        value |= (val << ET_BITOFFSET);
    }

    public void disableCrystalSleep(boolean ex) {
        int val = ex ? 1 : 0;
        value &= ~EX_MASK;
        value |= (val << EX_BITOFFSET);
    }

    public void setCrystalLoadCapacitance(CrystalLoadCap cap) {
        value &= ~CLC_MASK;
        value |= (cap.ordinal() << CLC_BITOFFSET);
    }

    public void setBasebandBandwidth(BasebandBandwidth bb) {
        value &= ~BB_MASK;
        value |= (bb.ordinal() << BB_BITOFFSET);
    }

    public void disableClockOutput(boolean ex) {
        int val = ex ? 1 : 0;
        value &= ~DC_MASK;
        value |= (val << DC_BITOFFSET);
    }

    @Override
    public int getValue() {
        return value & 0xFFFF;
    }

}
