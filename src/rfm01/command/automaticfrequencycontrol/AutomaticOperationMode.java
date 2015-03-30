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
 * In automatic operation mode (no strobe signal is needed from the
 * microcontroller to update the output offset register), the AFC circuit is
 * automatically enabled when VDI indicates a potential incoming signal during
 * the whole measurement cycle and the circuit measures the same result in two
 * subsequent cycles.
 *
 * There are three operation modes, example from the possible application:
 *
 * 1) (a1=0, a0=1) The circuit measures the frequency offset only once power up.
 * This way, the extended TX/RX maximum distance can be achieved. Possible
 * usage: In the final application when the user is inserted the battery the
 * circuit measures and compensate the frequency offset caused by the crystal
 * tolerances. This method enables to use cheaper quartz in the application and
 * provide quite good protection against locking in an interferer.
 *
 * 2a) (a1=1, a0=0) The circuit measures automatically the frequency offset
 * during an initial low data rate pattern -easier to receive- (i.e.: 00110011)
 * of the package and change the receiving frequency according that. The further
 * part of the package can be received by the corrected frequency setting.
 *
 * 2b) (a1=1, a0 =0) The transmitter must transmit the first part of the packet
 * with a step higher deviation and later there is a possibility to reduce it.
 *
 * In both cases(2a and 2b) when the VDI indicates poor receiving conditions
 * (VDI goes low) the output register is automatically cleared. It's suggested
 * to use when one receiver receives signal from more than one transmitter.
 *
 * 3) (a1=1, a0=1) It is similar to the 2a and 2b modes, but 3 is suggested to
 * use when a receiver operates with only one transmitter. After a complete
 * measuring cycle, the measured value is held independently of the sate of VDI
 * signal.
 */
public enum AutomaticOperationMode {

    /**
     * Auto mode off (Strobe is controlled by microcontroller
     */
    OFF,
    /**
     * Runs only once after each power-up
     */
    ONCE,
    /**
     * Drop the f<sub>offset</sub> value when the VDI signal is low
     */
    DROP,
    /**
     * Keep the f<sub>offset</sub> value independently form the state of the VDI
     * signal
     */
    KEEP
}
