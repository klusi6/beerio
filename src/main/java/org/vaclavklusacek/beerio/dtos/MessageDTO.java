package org.vaclavklusacek.beerio.dtos;

/**
 * MessageDTO is a Data Transfer Object that carries a message and a status.
 * It is used to transfer data between processes or components.
 */
public record MessageDTO(String message, String status) {
}