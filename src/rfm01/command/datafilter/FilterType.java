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
package rfm01.command.datafilter;

/**
 *
 * @author Jan Mucha <j.mucha@seznam.cz>
 * @version %I%, %G%
 * @since
 *
 */
public enum FilterType {

    /**
     * OOK to filter: the analog RSSI signal is used as received data. The DRSSI
     * threshold level is used for slicing.
     */
    OOK,
    /**
     * Digital filter: this is a digital realization of an analog RC filter
     * followed by a comparator with hysteresis. The time constant is
     * automatically adjusted to the bit rate defined by the Data Rate Command.
     */
    DIGITAL,
    /**
     * Reserved
     */
    RESERVED,
    /**
     * Analog RC filter: The demodulator output is fed to pin 7 over a 10 kOhm
     * resistor. The filter cut-off frequency is set by the external capacitor
     * connected to this pin and VSS.
     *
     * The table shows the optimal filter capacitor values for different data
     * rates:
     *
     * <table>
     * <th>Frequency [kbps]</th>Capacity<th></th>
     * <tr><td>1.2</td><td>12 nF</td></tr>
     * <tr><td>2.4</td><td>8.2 nF</td></tr>
     * <tr><td>4.8</td><td>6.8 nF</td></tr>
     * <tr><td>9.6</td><td>3.3 nF</td></tr>
     * <tr><td>19.2</td><td>1.5 nF</td></tr>
     * <tr><td>38.4</td><td>680 pF</td></tr>
     * <tr><td>57.6</td><td>270 pF</td></tr>
     * <tr><td>115.2</td><td>150 pF</td></tr>
     * <tr><td>256</td><td>100 pF</td></tr>
     * </table>
     *
     * If analog RC filter is selected the internal clock recovery circuit and
     * the FIFO cannot be used.
     */
    ANALOG
}
