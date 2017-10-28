package id.co.telkom.fam.data;

import id.co.telkom.fam.models.*;
import id.co.telkom.fam.utils.Config;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import play.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Iterator;

public class MasterData {

    private static MasterData instance = null;
    private static File file = new File(Config.getInstance().getPath() + "conf//Database.xlsx");
    DataFormatter formatter = new DataFormatter();

    public static MasterData getInstance() {
        if (instance == null) {
            instance = new MasterData();
        }
        return instance;
    }

    private boolean checkIfCellNull(Cell cell) {
        boolean result = true;
        if ("".equals(formatter.formatCellValue(cell))) {
            result = false;
        }
        return result;
    }

    public void createTREG(int sheetNumber) {
        if (TREG.find.all().size() == 0) {
            try {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
                    for (Row row : sheet) {
                        if (row.getRowNum() >= 1) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            TREG data = new TREG();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (checkIfCellNull(cell)) {
                                    switch (cell.getColumnIndex()) {
                                        case 0:
                                            data.name = formatter.formatCellValue(cell);
                                            break;
                                    }
                                }
                                data.updatedAt = new Date();
                                data.createdAt = new Date();
                                data.save();

                            }
                        }
                    }
                    Logger.info("Finished creating TREG");
                }
            } catch (Exception e) {
                Logger.error("Error when creating TREG");
            }
        }
    }

    public void createWITEL(int sheetNumber) {
        if (WITEL.find.all().size() == 0) {
            try {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
                    for (Row row : sheet) {
                        if (row.getRowNum() >= 1) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            WITEL data = new WITEL();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (checkIfCellNull(cell)) {
                                    switch (cell.getColumnIndex()) {
                                        case 0:
                                            data.treg = TREG.find.query().where().eq("name", cell.getStringCellValue()).findUnique();
                                            break;
                                        case 2:
                                            data.name = formatter.formatCellValue(cell);
                                            break;
                                        case 3:
                                            data.GMWitel = formatter.formatCellValue(cell);
                                            break;
                                        case 4:
                                            data.contactGMWitel = "0" + formatter.formatCellValue(cell);
                                            break;
                                        case 5:
                                            data.managerLogistic = formatter.formatCellValue(cell);
                                            break;
                                        case 6:
                                            data.contactManagerLogistic = "0" + formatter.formatCellValue(cell);
                                            break;
                                    }
                                }
                                data.updatedAt = new Date();
                                data.createdAt = new Date();
                                if (!"".equals(data.name)) {
                                    data.save();
                                }

                            }
                        }
                    }
                    Logger.info("Finished creating WITEL");
                }
            } catch (Exception e) {
                Logger.error("Error when creating WITEL");
            }
        }
    }

    public void createArea(int sheetNumber) {
        if (Area.find.all().size() == 0) {
            try {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
                    for (Row row : sheet) {
                        if (row.getRowNum() >= 1) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            Area data = new Area();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (checkIfCellNull(cell)) {
                                    switch (cell.getColumnIndex()) {
                                        case 1:
                                            data.witel = WITEL.find.query().where().eq("name", cell.getStringCellValue()).findUnique();
                                            break;
                                        case 2:
                                            data.name = formatter.formatCellValue(cell);
                                            break;
                                    }
                                }
                                data.updatedAt = new Date();
                                data.createdAt = new Date();
                                if (!"".equals(data.name)) {
                                    data.save();
                                }
                            }
                        }
                    }
                    Logger.info("Finished creating Area");
                }
            } catch (Exception e) {
                Logger.error("Error when creating Area");
            }
        }
    }

    public void createFMGsd(int sheetNumber) {
        if (FMGSD.find.all().size() == 0) {
            try {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
                    for (Row row : sheet) {
                        if (row.getRowNum() >= 1) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            FMGSD data = new FMGSD();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (checkIfCellNull(cell)) {
                                    switch (cell.getColumnIndex()) {
                                        case 1:
                                            WITEL witel = WITEL.find.query().where().eq("name", cell.getStringCellValue()).findUnique();
                                            data.area = Area.find.query().where().eq("witel_id", witel.id).findUnique();
                                            break;
                                        case 2:
                                            data.officeAddress = formatter.formatCellValue(cell);
                                            break;
                                        case 3:
                                            data.name = formatter.formatCellValue(cell);
                                            break;
                                        case 4:
                                            data.contact = "0" + formatter.formatCellValue(cell);
                                            break;
                                        case 5:
                                            data.operationManager = formatter.formatCellValue(cell);
                                            break;
                                        case 6:
                                            data.contactOperationManager = "0" + formatter.formatCellValue(cell);
                                            break;
                                    }
                                }
                                data.updatedAt = new Date();
                                data.createdAt = new Date();
                                if (!"".equals(data.name)) {
                                    data.save();
                                }
                            }
                        }
                    }
                    Logger.info("Finished creating FMGSD");
                }
            } catch (Exception e) {
                Logger.error("Error when creating FMGSD");
                e.printStackTrace();
            }
        }
    }

    public void createElectricityPAM(int sheetNumber) {
        if (ElectricityPAM.find.all().size() == 0) {
            try {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
                    for (Row row : sheet) {
                        if (row.getRowNum() >= 1) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            ElectricityPAM data = new ElectricityPAM();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (checkIfCellNull(cell)) {
                                    switch (cell.getColumnIndex()) {
                                        case 0:
                                            data.id = (long) cell.getNumericCellValue();
                                            break;
                                        case 1:
                                            data.address = formatter.formatCellValue(cell);
                                            break;
                                        case 2:
                                            data.name = formatter.formatCellValue(cell);
                                            break;
                                        case 3:
                                            data.status = (int) cell.getNumericCellValue();
                                            break;
                                    }
                                }
                                data.updatedAt = new Date();
                                data.createdAt = new Date();
                                if (!"".equals(data.name)) {
                                    data.save();
                                }
                            }
                        }
                    }
                    Logger.info("Finished creating ElectricityPAM");
                }
            } catch (Exception e) {
                Logger.error("Error when creating ElectricityPAM");
                e.printStackTrace();
            }
        }
    }

    public void createElectricityPAMDetail(int sheetNumber) {
        if (ElectricityPAMDetail.find.all().size() == 0) {
            try {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
                    for (Row row : sheet) {
                        if (row.getRowNum() >= 1) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            ElectricityPAMDetail data = new ElectricityPAMDetail();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (checkIfCellNull(cell)) {
                                    switch (cell.getColumnIndex()) {
                                        case 0:
                                            data.electricityPAM = ElectricityPAM.find.query().where().eq("id", (long) cell.getNumericCellValue()).findUnique();
                                            break;
                                        case 1:
                                            data.period = cell.getDateCellValue();
                                            break;
                                        case 2:
                                            data.rate = formatter.formatCellValue(cell);
                                            break;
                                        case 3:
                                            data.power = cell.getNumericCellValue();
                                            break;
                                        case 4:
                                            data.startTotal = cell.getNumericCellValue();
                                            break;
                                        case 5:
                                            data.endTotal = cell.getNumericCellValue();
                                            break;
                                        case 6:
                                            data.used = cell.getNumericCellValue();
                                            break;
                                        case 7:
                                            data.price = cell.getNumericCellValue();
                                            break;
                                    }
                                }
                                data.updatedAt = new Date();
                                data.createdAt = new Date();
                                if (data.electricityPAM != null) {
                                    data.save();
                                }
                            }
                        }
                    }
                    Logger.info("Finished creating ElectricityPAMDetail");
                }
            } catch (Exception e) {
                Logger.error("Error when creating ElectricityPAMDetail");
                e.printStackTrace();
            }
        }
    }

    public void createOffice(int sheetNumber) {
        if (Office.find.all().size() == 0) {
            try {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
                    for (Row row : sheet) {
                        if (row.getRowNum() >= 1) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            Office data = new Office();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (checkIfCellNull(cell)) {
                                    switch (cell.getColumnIndex()) {
                                        case 0:
                                            data.witel = WITEL.find.query().where().eq("name", cell.getStringCellValue()).findUnique();
                                            break;
                                        case 1:
                                            data.electricity = ElectricityPAM.find.byId((long) cell.getNumericCellValue());
                                            break;
                                        case 2:
                                            data.pam = ElectricityPAM.find.byId((long) cell.getNumericCellValue());
                                            break;
                                        case 3:
                                            data.name = formatter.formatCellValue(cell);
                                            break;
                                        case 4:
                                            data.address = formatter.formatCellValue(cell);
                                            break;
                                        case 5:
                                            data.phoneNumber = "0" + formatter.formatCellValue(cell);
                                            break;
                                    }
                                }
                                data.updatedAt = new Date();
                                data.createdAt = new Date();
                                if (!"".equals(data.name)) {
                                    data.save();
                                }
                            }
                        }
                    }
                    Logger.info("Finished creating Office");
                }
            } catch (Exception e) {
                Logger.error("Error when creating Office");
                e.printStackTrace();
            }
        }
    }

    public void createLocation(int sheetNumber) {
        if (Location.find.all().size() == 0) {
            try {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
                    for (Row row : sheet) {
                        if (row.getRowNum() >= 1) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            Location data = new Location();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (checkIfCellNull(cell)) {
                                    switch (cell.getColumnIndex()) {
                                        case 0:
                                            data.id = Long.getLong(formatter.formatCellValue(cell));
                                            break;
                                        case 1:
                                            data.office = Office.find.query().where().eq("electricity_id", Long.valueOf(formatter.formatCellValue(cell))).findUnique();
                                            break;
                                        case 2:
                                            data.floor = (int) cell.getNumericCellValue();
                                            break;
                                        case 3:
                                            data.roomName = formatter.formatCellValue(cell);
                                            break;
                                    }
                                }
                                data.updatedAt = new Date();
                                data.createdAt = new Date();
                                if (data.office != null) {
                                    data.save();
                                }
                            }
                        }
                    }
                    Logger.info("Finished creating Location");
                }
            } catch (Exception e) {
                Logger.error("Error when creating Location");
                e.printStackTrace();
            }
        }
    }

    public void createVendor(int sheetNumber) {
        if (Vendor.find.all().isEmpty()) {
            try {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
                    for (Row row : sheet) {
                        if (row.getRowNum() >= 1) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            Vendor data = new Vendor();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (checkIfCellNull(cell)) {
                                    switch (cell.getColumnIndex()) {
                                        case 0:
                                            data.name = formatter.formatCellValue(cell);
                                            break;
                                        case 1:
                                            data.address = formatter.formatCellValue(cell);
                                            break;
                                        case 5:
                                            data.vendorPIC = formatter.formatCellValue(cell);
                                            break;
                                        case 6:
                                            data.contactVendorPIC = formatter.formatCellValue(cell);
                                            break;
                                    }
                                }
                                data.updatedAt = new Date();
                                data.createdAt = new Date();
                                if (data.name != null) {
                                    data.save();
                                }
                            }
                        }
                    }
                    Logger.info("Finished creating Vendor");
                }
            } catch (Exception e) {
                Logger.error("Error when creating Vendor");
                e.printStackTrace();
            }
        }
    }


    public void createAssetType(int sheetNumber) {
        if (AssetType.find.all().size() == 0) {
            try {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
                    for (Row row : sheet) {
                        if (row.getRowNum() >= 1) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            AssetType data = new AssetType();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (checkIfCellNull(cell)) {
                                    switch (cell.getColumnIndex()) {
                                        case 0:
                                            data.name = formatter.formatCellValue(cell);
                                            break;
                                    }
                                }
                                data.updatedAt = new Date();
                                data.createdAt = new Date();
                                if (data.name != null) {
                                    data.save();
                                }
                            }
                        }
                    }
                    Logger.info("Finished creating AssetType");
                }
            } catch (Exception e) {
                Logger.error("Error when creating Location");
                e.printStackTrace();
            }
        }
    }

    protected void createAsset(int sheetNumber) {
        if (Asset.find.all().size() == 0) {
            try {
                if (file != null) {
                    FileInputStream fis = new FileInputStream(file);
                    XSSFWorkbook workbook = new XSSFWorkbook(fis);
                    XSSFSheet sheet = workbook.getSheetAt(sheetNumber);
                    for (Row row : sheet) {
                        if (row.getRowNum() >= 1) {
                            Iterator<Cell> cellIterator = row.cellIterator();
                            Asset data = new Asset();
                            while (cellIterator.hasNext()) {
                                Cell cell = cellIterator.next();
                                if (checkIfCellNull(cell)) {
                                    switch (cell.getColumnIndex()) {
                                        case 0:
                                            data.id = (long) cell.getNumericCellValue();
                                            break;
                                        case 1:
                                            data.assetType = AssetType.find.query().where().eq("name", formatter.formatCellValue(cell)).findUnique();
                                            break;
                                        case 2:
                                            data.location = Location.find.byId((long) cell.getNumericCellValue());
                                            break;
                                        case 3:
                                            data.function = formatter.formatCellValue(cell);
                                            break;
                                        case 4:
                                            data.capacity = Double.parseDouble(formatter.formatCellValue(cell));
                                            break;
                                        case 5:
                                            data.unit = formatter.formatCellValue(cell);
                                            break;
                                        case 6:
                                            data.merk = formatter.formatCellValue(cell);
                                            break;
                                        case 7:
                                            data.type = formatter.formatCellValue(cell);
                                            break;
                                        case 8:
                                            data.series = formatter.formatCellValue(cell);
                                            break;
                                        case 9:
                                            data.quantity = Integer.parseInt(formatter.formatCellValue(cell));
                                            break;
                                        case 10:
                                            data.unitPrice = Double.parseDouble(formatter.formatCellValue(cell));
                                            break;
                                        case 11:
                                            data.performance = cell.getNumericCellValue();
                                            break;
                                        case 12:
                                            data.installationDate = cell.getDateCellValue();
                                            break;
                                        case 13:
                                            data.usedYear = Integer.parseInt(formatter.formatCellValue(cell));
                                            break;
                                        case 14:
                                            data.guaranteeNumber = formatter.formatCellValue(cell);
                                            break;
                                        case 15:
                                            data.guaranteePeriod = cell.getDateCellValue();
                                            break;
                                        case 16:
                                            data.guaranteeExpireDate = cell.getDateCellValue();
                                            break;
                                        case 18:
                                            data.vendor = Vendor.find.query().where().eq("name", formatter.formatCellValue(cell)).findUnique();
                                            break;
                                        case 19:
                                            data.statusAsset = Integer.valueOf(formatter.formatCellValue(cell));
                                            break;
                                    }
                                }
                                data.updatedAt = new Date();
                                data.createdAt = new Date();
                                if (!"".equals(data.function)) {
                                    data.save();
                                }
                            }
                        }
                    }
                    Logger.info("Finished creating Asset");
                }
            } catch (Exception e) {
                Logger.error("Error when creating Asset");
                e.printStackTrace();
            }
        }
    }
}
