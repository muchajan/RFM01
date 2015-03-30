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

import rfm01.command.receiversetting.LNAGain;
import rfm01.command.receiversetting.RSSITreshold;
import rfm01.command.receiversetting.VDIOutput;

/**
 *
 * @author Jan Mucha j.mucha@seznam.cz
 */
public class ReceiverSetting implements Command {

    private static final int CMD = 0xC000;

    private static final int VDIO_MASK = 0x00C0;
    private static final int VDIO_BITOFFSET = 6;

    private static final int LNAG_MASK = 0x0030;
    private static final int LNAG_BITOFFSET = 4;

    private static final int RSSIT_MASK = 0x000E;
    private static final int RSSIT_BITOFFSET = 1;

    private int value = 0xC0C1;

    public void setVDIOutput(VDIOutput vdio) {
        value &= ~VDIO_MASK;
        value |= (vdio.ordinal() << VDIO_BITOFFSET);
    }

    public void setLNAGain(LNAGain gain) {
        value &= ~LNAG_MASK;
        value |= (gain.ordinal() << LNAG_BITOFFSET);
    }

    /**
     *
     * @param rssit
     */
    public void setRSSIThreshold(RSSITreshold rssit) {
        value &= ~RSSIT_MASK;
        value |= (rssit.ordinal() << RSSIT_BITOFFSET);
    }

    /**
     * Enables/disables the whole receiver chain. Enable/disable of the wake-up
     * timer and the low battery detector are not affected by this setting.
     * Note: Clock tail is not generated when the crystal oscillator is
     * controlled by en bit.
     *
     * @param en: whether to enable the whole receiver chain.
     */
    public void setEnable(boolean en) {
        if (en) {
            value &= ~1;
        } else {
            value |= 1;
        }
    }

    @Override
    public int getValue() {
        return value;
    }

}
