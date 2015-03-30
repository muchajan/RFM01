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
 * Valid Data Indicator Output options
 *
 * @author Jan Mucha j.mucha@seznam.cz
 */
public enum VDIOutput {

    /**
     * Digital Receiver Strength Indication
     */
    DRSSI,
    /**
     * Data Quality Detector
     */
    DQD,
    /**
     * Clock recovery lock
     */
    CL,
    /**
     * {@link #DRSSI} and {@link #DQD}
     */
    DRSSI_DQD

}
