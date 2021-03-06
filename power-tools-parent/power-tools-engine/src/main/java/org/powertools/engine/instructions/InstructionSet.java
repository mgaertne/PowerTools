/* Copyright 2012-2014 by Martin Gijsen (www.DeAnalist.nl)
 *
 * This file is part of the PowerTools engine.
 *
 * The PowerTools engine is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * The PowerTools engine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with the PowerTools engine. If not, see <http://www.gnu.org/licenses/>.
 */

package org.powertools.engine.instructions;


/**
 * An instruction set contains instruction implementations.
 * It retrieves an executor for an implemented instruction.
 */
public interface InstructionSet {
    /**
     * the name of the instruction set
     * @return the instruction set name
     */
    String getName ();

    /**
     * prepares the instruction set
     */
    void setup ();

    /**
     * retrieves an executor for an instruction (if is implemented once)
     * @param   instructionName the instruction name
     * @return  an executor for the instruction (if is implemented once)
     */
    Executor getExecutor (String instructionName);

    /**
     * cleans up the instruction set when it is no longer needed
     */
    void cleanup ();
}
