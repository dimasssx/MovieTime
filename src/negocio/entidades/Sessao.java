package negocio.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.time.MonthDay;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Sessao implements Serializable {
    @Serial
    private static final long serialVersionUID = -4009776605163947716L;
    private LocalTime horario;
    private MonthDay dia;
    private Filme filme;
    private Sala sala;

    public Sessao(Filme filme, String horario,Sala sala,String dia){
        this.filme = filme;
        this.sala = sala;
        this.horario = LocalTime.parse(horario);
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd-MM");
        this.dia = MonthDay.parse(dia, formater);
    }

    @Override
    public String toString() {
        return "negocio.entidades.Sessao{" +
                "horario=" + horario +
                ", filme=" + filme +
                ", sala=" + sala + "dia: "+ dia;

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

}
