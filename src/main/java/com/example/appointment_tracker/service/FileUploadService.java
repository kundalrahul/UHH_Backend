package com.example.appointment_tracker.service;

import com.example.appointment_tracker.domain.Patient;
import com.example.appointment_tracker.repository.PatientRepository;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Iterator;

@Service
public class FileUploadService {

    @Autowired
    private PatientRepository patientRepository;

    public void processFile(MultipartFile file) throws Exception {
        try (InputStream is = file.getInputStream(); Workbook workbook = new XSSFWorkbook(is)) {
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            // Skip header row
            if (rows.hasNext()) rows.next();

            while (rows.hasNext()) {
                Row row = rows.next();
                String email = row.getCell(0).getStringCellValue();
                String firstName = row.getCell(1).getStringCellValue();
                String lastName = row.getCell(2).getStringCellValue();
                String location = row.getCell(3).getStringCellValue();
                String status = row.getCell(4).getStringCellValue();

                // Create a new Patient object
                Patient patient = new Patient();
                patient.setEmail(email);
                patient.setName(firstName + " " + lastName);
                patient.setLocation(location);
                patient.setStatus(status.toLowerCase());

                // Save patient to the database
                patientRepository.save(patient);
            }
        }
    }
}
