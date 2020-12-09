package mappingclass;

import java.util.List;

public final class InitialData {
    private List<NewConsumer> consumers;
    private List<Distributor> distributors;

    public List<NewConsumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(final List<NewConsumer> consumers) {
        this.consumers = consumers;
    }

    public List<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(final List<Distributor> distributors) {
        this.distributors = distributors;
    }

    @Override
    public String toString() {
        return "InitialData{"
                + "consumers=" + consumers
                + ", distributors=" + distributors
                + '}';
    }
}
