package com.example.cleancoder.subclassoverride;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class AuditManagerTest {
  class TestAuditManager extends AuditManager {
      private String[] files;
      private String[] lines;
      private String record;
      private String filePath;

      public TestAuditManager(int maxEntriesPerFile, String directoryName) {
          super(maxEntriesPerFile, directoryName);
      }

      @Override
      protected String[] getFiles() {
          return this.files;
      }

      @Override
      protected String[] readAllLines(String currentFilePath) {
          return this.lines;
      }

      @Override
      protected void writeAllText(String filePath, String record) {
          this.filePath = filePath;
          this.record = record;
      }
  }


  @Test
  void addRecordWithNormalCase() {
      String directoryName = "audits";
      String[] files = {
              directoryName + "\\audit_1.txt",
              directoryName + "\\audit_2.txt"
      };
      String[] lines = {
              "Peter; 2019-04-06T16:30:00",
              "Jane; 2019-04-06T16:40:00",
              "Jack; 2019-04-06T17:00:00"
      };
      LocalDateTime dateTime = LocalDateTime.of(2022, 3, 25, 14, 0);
      String visitorName = "Alice";

      TestAuditManager auditManager = new TestAuditManager(3, directoryName);
      auditManager.files = files;
      auditManager.lines = lines; // given (stubbing)

      auditManager.addRecord(visitorName, dateTime);

      // characterize test
      assertThat(auditManager.record).isEqualTo(visitorName + ";" + dateTime.toString());
      assertThat(auditManager.filePath).isEqualTo("audits:audit_2.txt");
  }
}
