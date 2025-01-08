package main.main.jwtauth.util;
import io.jsonwebtoken.io.IOException;
import main.main.jwtauth.model.listDoan;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;



import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class importUtils {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
        static String[] HEADERs = { "ID", "FullName", "Unit", "Country", "TripPurpose", "JobTitle", "Email", "SelfFunded", "Sponsor", "Hospital", "HD/BC", "InvitationUnit", "Doan", "PartyMember", "ForeignTripCount", "NotificationNumber",
                "NotificationDate", "city", "StartDate", "EndDate", "BirthDate", "Gender", "Position", "PhoneNumber", "PartyBranch", "PartyPosition",
                "Contract", "Official", "JobName", "RestCount", "Alternative", "SubmitDay"};
        static String SHEET = "data";
        public static boolean hasExcelFormat(MultipartFile file) {
            if (!TYPE.equals(file.getContentType())) {
                return false;
            }
            return true;
        }
        public static List<listDoan> excelToDoanList(InputStream is){
            try{
                Workbook workbook = new XSSFWorkbook(is);
                Sheet sheet = workbook.getSheet(SHEET);
                Iterator<Row> rows = sheet.iterator();
                List<listDoan> doanList = new ArrayList<listDoan>();
                int rowNumber = 0;
                while (rows.hasNext()){
                    Row currentRow = rows.next();
                    if (rowNumber == 0){
                        rowNumber++;
                        continue;
                    }
                    Iterator<Cell> cellsInrow = currentRow.iterator();
                    listDoan doan = new listDoan();
                    int cellIdx = 0;
                    while (cellsInrow.hasNext()){
                        Cell currentCell = cellsInrow.next();
                        switch (cellIdx){
                            case 0:
                                doan.setId((long) currentCell.getNumericCellValue());
                                break;
                            case 1:
                                doan.setFullName(currentCell.getStringCellValue());
                                break;
                            case 2:
                                doan.setUnit(currentCell.getStringCellValue());
                                break;
                            case 3:
                                doan.setCountry(currentCell.getStringCellValue());
                                break;
                            case 4:
                                doan.setTripPurpose(currentCell.getStringCellValue());
                                break;
                            case 5:
                                doan.setJobTitle(currentCell.getStringCellValue());
                                break;
                            case 6:
                                doan.setEmail(currentCell.getStringCellValue());
                                break;
                            case 7:
                                doan.setSelfFunded(currentCell.getStringCellValue());
                                break;
                            case 8:
                                doan.setSponsor(currentCell.getStringCellValue());
                                break;
                            case 9:
                                doan.setHospital(currentCell.getStringCellValue());
                                break;
                            case 10:
                                doan.setHdBc(currentCell.getStringCellValue());
                                break;
                            case 11:
                                doan.setInvitationUnit(currentCell.getStringCellValue());
                                break;
                            case 12:
                                doan.setDoan(currentCell.getStringCellValue());
                                break;
                            case 13:
                                doan.setPartyMember(currentCell.getStringCellValue());
                                break;
                            case 14:
                                doan.setForeignTripCount(currentCell.getStringCellValue());
                                break;
                            case 15:
                                doan.setNotificationNumber(currentCell.getStringCellValue());
                                break;
                            case 16:
                                doan.setNotificationNumber(currentCell.getStringCellValue());
                                break;
                            case 17:
                                doan.setNotificationDate(currentCell.getStringCellValue());
                                break;
                            case 18:
                                doan.setCity(currentCell.getStringCellValue());
                                break;
                            case 19:
                                doan.setStartDate(currentCell.getDateCellValue());
                                break;
                            case 20:
                                doan.setEndDate(currentCell.getDateCellValue());
                                break;
                            case 21:
                                doan.setBirthDate(currentCell.getDateCellValue());
                                break;
                            case 22:
                                doan.setGender(currentCell.getStringCellValue());
                                break;
                            case 23:
                                doan.setPosition(currentCell.getStringCellValue());
                                break;
                            case 24:
                                doan.setPhoneNumber(currentCell.getStringCellValue());
                                break;
                            case 25:
                                doan.setPartyBranch(currentCell.getStringCellValue());
                                break;
                            case 26:
                                doan.setPartyPosition(currentCell.getStringCellValue());
                                break;
                            case 29:
                                doan.setJobName(currentCell.getStringCellValue());
                                break;
                            case 30:
                                doan.setRestCount(currentCell.getStringCellValue());
                                break;
                            case 31:
                                doan.setAlternative(currentCell.getStringCellValue());
                                break;
                            case 32:
                                doan.setSubmitDay(currentCell.getStringCellValue());
                                break;
                            default:
                                break;
                        }
                        cellIdx++;
                    }
                    doanList.add(doan);
                }
                workbook.close();
                return doanList;
            }catch(IOException e){
                throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
            } catch (java.io.IOException e) {
                throw new RuntimeException(e);
            }
        }
}
