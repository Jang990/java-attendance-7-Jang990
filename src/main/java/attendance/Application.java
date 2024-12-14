package attendance;

import attendance.attendance.HistoryFormatter;
import attendance.io.DateReader;
import attendance.io.NicknameReader;
import attendance.io.attendance.AttendancesFileReader;
import attendance.io.confirmation.ConfirmationReader;
import attendance.io.function.FunctionSelection;
import attendance.io.function.FunctionSelectionReader;
import attendance.io.InputReader;
import attendance.io.modification.ModificationReader;
import attendance.myfunctions.ConfirmationFunction;
import attendance.myfunctions.CrewHistoryFunction;
import attendance.myfunctions.ModificationFunction;

public class Application {
    private static CrewAttendanceRepository repository = crewAttendanceRepository();
    public static void main(String[] args) {
        FunctionSelectionReader functionSelectionReader = functionSelectionReader();
        ConfirmationReader confirmationReader = new ConfirmationReader(inputReader(), repository);

        FunctionSelection function;
        ConfirmationFunction confirmationFunction = new ConfirmationFunction(confirmationReader, repository);
        ModificationReader reader = new ModificationReader(inputReader(), nicknameReader(), dateReader());
        ModificationFunction modificationFunction = new ModificationFunction(reader, repository);
        CrewHistoryFunction crewHistoryFunction = new CrewHistoryFunction(nicknameReader(), repository, new HistoryFormatter());
        do {
            function = functionSelectionReader.read();
            if(function.equals(FunctionSelection.CONFIRMATION))
                confirmationFunction.apply();
            if(function.equals(FunctionSelection.MODIFICATION))
                modificationFunction.apply();
            if(function.equals(FunctionSelection.CREW_HISTORY))
                crewHistoryFunction.apply();
        } while (!function.equals(FunctionSelection.QUIT));
    }

    private static NicknameReader nicknameReader() {
        return new NicknameReader(inputReader(), repository);
    }

    private static DateReader dateReader() {
        return new DateReader(inputReader());
    }

    private static CrewAttendanceRepository crewAttendanceRepository() {
        return new CrewAttendanceRepository(fileReader());
    }

    private static AttendancesFileReader fileReader() {
        return new AttendancesFileReader();
    }

    private static FunctionSelectionReader functionSelectionReader() {
        return new FunctionSelectionReader(inputReader());
    }

    private static InputReader inputReader() {
        return new InputReader();
    }
}
