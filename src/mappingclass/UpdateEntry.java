package mappingclass;

import java.util.List;

public final class UpdateEntry {
    private List<NewConsumer> newConsumers;
    private List<CostChange> costsChanges;

    public List<NewConsumer> getNewConsumers() {
        return newConsumers;
    }

    public void setNewConsumers(final List<NewConsumer> newConsumers) {
        this.newConsumers = newConsumers;
    }

    public List<CostChange> getCostsChanges() {
        return costsChanges;
    }

    public void setCostsChanges(final List<CostChange> costsChanges) {
        this.costsChanges = costsChanges;
    }

    @Override
    public String toString() {
        return "UpdateEntry{"
                + "newConsumers=" + newConsumers
                + ", costsChanges=" + costsChanges
                + '}';
    }
}
