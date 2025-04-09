package negocio.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.time.MonthDay;
import java.time.LocalTime;
import negocio.entidades.*;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Sessao implements Serializable {
    @Serial
    private static final long serialVersionUID = -4009776605163947716L;
    private LocalTime horario;
    private MonthDay dia;
    private Filme filme;
    private Sala sala;
    private Assento[][] assentos;



    public Sessao(Filme filme, String horario,Sala sala,String dia){
        this.filme = filme;
        this.sala = sala;
        this.horario = LocalTime.parse(horario);
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM");
        this.dia = MonthDay.parse(dia, formater);
        this.assentos = new Assento[sala.getFileiras()][sala.getAssentosPorFileira()];
        inicializarAssentos();
    }

    private void inicializarAssentos() {
        for (int i = 0; i < sala.getFileiras(); i++) {
            for (int j = 0; j < sala.getAssentosPorFileira(); j++) {
                assentos[i][j] = new Assento(i + 1, j + 1);
            }
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM");

        return filme + "| Horario: " + horario + " "+sala + getDiaFormatado();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Sessao sessao = (Sessao) o;
        return Objects.equals(horario, sessao.horario) && Objects.equals(sala, sessao.sala) && Objects.equals(dia,sessao.dia) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(horario, sala,dia);
    }
    
    public Sala getSala() { //Augusto
        return this.sala;
    }
    public Filme getFilme() { //Augusto
        return this.filme;
    }
    public LocalTime getHorario() {return this.horario;}
    public MonthDay getDia() {return this.dia;}

    public String getDiaFormatado() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM");
        return this.dia.format(formatter);
    }

}
