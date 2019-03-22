public class RequireToFutureWork
{
    private String specialty;
    private String conditionOfWork;
    private int minSalary;

    RequireToFutureWork(String specialty, String conditionOfWork, int minSalary)
    {
        this.specialty = specialty;
        this.conditionOfWork = conditionOfWork;
        this.minSalary = minSalary;
    }

    public String getSpecialty() { return specialty; }

    public int getMinSalary() { return minSalary; }

    public String getConditionOfWork() { return conditionOfWork; }

    @Override
    public String toString()
    {
        if(specialty != null && conditionOfWork == null && minSalary == 0)
            return "Specialty - " + specialty;
        else if((specialty != null && conditionOfWork != null && minSalary == 0))
            return  "Specialty - " + specialty + ". On the special condition of work - " + conditionOfWork + "$";
        else if (specialty != null && conditionOfWork != null && minSalary != 0)
            return  "Specialty - " + specialty + ". On the special condition of work - " + conditionOfWork+". On the minimal salary: - " + minSalary + "$";
        else if (specialty != null && conditionOfWork == null && minSalary != 0)
            return  "Specialty - " + specialty + ". On the minimal salary: - " + minSalary + "$";
        else if (specialty == null && conditionOfWork != null && minSalary == 0)
            return "On the special condition of work - " + conditionOfWork;
        else
            return  "On the minimal salary: - " + minSalary + "$";
    }
}