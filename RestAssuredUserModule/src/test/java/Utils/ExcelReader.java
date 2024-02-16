package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;

public class ExcelReader {
    private static final String FILE_NAME = "userdata.xlsx"; // Excel file path

    public static class UserData {
        private int userId;
        private String username;

        public UserData(int userId, String username) {
            this.userId = userId;
            this.username = username;
        }

        public int getUserId() {
            return userId;
        }

        public String getUsername() {
            return username;
        }
    }

    public static UserData readUserData() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
            Row row = sheet.getRow(1); // Assuming data is in the second row
            
            // Assuming User ID is in the first column and Username is in the second column
            Cell cellUserId = row.getCell(0);
            Cell cellUsername = row.getCell(1);

            if (cellUserId.getCellType() == CellType.NUMERIC && cellUsername.getCellType() == CellType.STRING) {
                int userId = (int) cellUserId.getNumericCellValue();
                String username = cellUsername.getStringCellValue();
                return new UserData(userId, username);
            } else {
                throw new IllegalStateException("Invalid cell types for User ID or Username");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
