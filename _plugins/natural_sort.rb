module Jekyll
  module NaturalSortFilter
    def natural_sort(input, property = nil)
      return input unless input.is_a?(Array)

      input.sort_by do |item|
        # If a property is given, sort by that property of the object
        # Otherwise, sort the item itself (assuming it's a string)
        s = property ? item[property].to_s : item.to_s
        
        # Split the string into chunks of digits and non-digits
        # Map digit chunks to integers for numerical comparison
        s.scan(/(\d+)|(\D+)/).map do |digits, non_digits|
          if digits
            [0, digits.to_i] # 0 prefix to sort numbers before letters if needed, or just consistent structure
          else
            [1, non_digits]
          end
        end
      end
    end
  end
end

Liquid::Template.register_filter(Jekyll::NaturalSortFilter)
