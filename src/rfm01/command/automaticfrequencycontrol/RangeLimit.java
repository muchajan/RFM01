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
package rfm01.command.automaticfrequencycontrol;

/**
 *
 * @author Jan Mucha <j.mucha@seznam.cz>
 * @version %I%, %G%
 * @since
 *
 * f<sub>res</sub>:
 * <table>
 * <th>Band [Mhz]</th><th>f<sub>res [kHz]</sub></th>
 * <tr><td>315, 433</td><td>2.5</td></tr>
 * <tr><td>868</td><td>5</td></tr>
 * <tr><td>915</td><td>7.5</td></tr>
 * </table>
 */
public enum RangeLimit {

    _NORESTRICTION,
    /**
     * +15/-16 f<sub>res</sub>
     */
    _15,
    /**
     * +7/-8 f<sub>res</sub>
     */
    _7,
    /**
     * +3/-4 f<sub>res</sub>
     */
    _3
}
