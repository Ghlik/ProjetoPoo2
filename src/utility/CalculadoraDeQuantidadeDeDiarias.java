package utility;

import java.time.Duration;
import java.time.LocalDateTime;

public class CalculadoraDeQuantidadeDeDiarias {

    public long calcularQuantidadeDeDiarias (LocalDateTime dataInicial, LocalDateTime dataFinal){
        if (isDiariaIncompleta(dataInicial, dataFinal)){
            return calcularPeridoEmMinutos(dataInicial, dataFinal)/(24*60) + 1;
        }
        return calcularPeridoEmMinutos(dataInicial, dataFinal)/(24*60);
    }
    private long calcularPeridoEmMinutos(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return Duration.between(dataInicial, dataFinal).toMinutes();
    }
    private boolean isDiariaIncompleta(LocalDateTime dataInicial, LocalDateTime dataFinal){
        return calcularPeridoEmMinutos(dataInicial, dataFinal) % (24*60) > 0;
    }
}