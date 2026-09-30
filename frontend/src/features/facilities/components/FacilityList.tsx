import { useFacilities } from "@/features/facilities/api/useFacilities.ts"
import { useFacilityFilter } from "@/features/facilities/hooks/useFacilityFilter.tsx"
import { Label } from "@/components/ui/label.tsx"
import { Input } from "@/components/ui/input.tsx"

export const FacilityList = () => {
  const { data: facilities, isLoading, isError } = useFacilities()
  const {
    minCapacity,
    setMinCapacity,
    filteredFacilities,
  } = useFacilityFilter(facilities);

  if (isLoading) return <div>Loading facilities...</div>;
  if (isError) return <div>Failed to load facilities.</div>;

  return (
    <div className="space-y-4">
      <div className="flex gap-2 items-center">
        <Label>Min Capacity:</Label>
        <Input
          type="number"
          value={minCapacity}
          onChange={(e) => setMinCapacity(Number(e.target.value))}
          className="border p-1 rounded"
        />
      </div>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
        {filteredFacilities.map((facility) => (
          <div key={facility.id} className="p-4 border rounded-lg shadow-sm">
            <h3 className="font-bold text-lg">{facility.name}</h3>
            <p>Capacity: {facility.capacity}</p>
            <p>Price: ${facility.hourlyRate}/hr</p>
          </div>
        ))}
      </div>
    </div>
  );
}