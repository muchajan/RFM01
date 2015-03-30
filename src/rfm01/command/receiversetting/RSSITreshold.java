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
package rfm01.command.receiversetting;

/**
 * Receiver Signal Strength Indicator threshold options. The RSSI threshold
 * depends on the {@link LNAGain}, the real RSSI threshold can be calculated:
 * RSSI<sub>th</sub> = RSSI<sub>setth</sub> + G<sub>LNA</sub>
 *
 * @author Jan Mucha j.mucha@seznam.cz
 * @version %I%, %G%
 * @since
 */
public enum RSSITreshold {

    /**
     * -103dBm
     */
    _103,
    /**
     * -97dBm
     */
    _97,
    /**
     * -91dBm
     */
    _91,
    /**
     * -85dBm
     */
    _85,
    /**
     * -79dBm
     */
    _79,
    /**
     * -73dBm
     */
    _73,
    /**
     * Reserved
     */
    RESERVED0,
    /**
     * Reserved
     */
    RESERVED1

}
