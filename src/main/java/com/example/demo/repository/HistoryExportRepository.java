package com.example.demo.repository;

import com.example.demo.model.HistoryExport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryExportRepository  extends JpaRepository<HistoryExport, Long> {
}
